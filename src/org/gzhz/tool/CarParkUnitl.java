package org.gzhz.tool;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.gzhz.park.PlateRecognition;
import org.gzhz.park.bean.CarInfo;
import org.gzhz.park.bean.CarPort;
import org.gzhz.park.dao.ICarInfoDao;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月16日 上午9:54:00 
* @version 1.0 
* @description 用于处理所有有关停车场的业务  
*/
@Component
public class CarParkUnitl {
	@Resource
	private MyDateUnitl myDateUnitl;
	@Resource
	private CarParkUnitl carParkUnitl;
	@Resource
	private ICarInfoDao iCarInfoDao;
	

	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月16日 上午10:03:49 
	* @version 1.0 
	* @parameter  String carLisence 车牌号
	* @description 向当前车场车辆表中添加车辆信息
	* @return  CarInfo car 
	*/
	public CarInfo addCar(String carLisence){
		String date = myDateUnitl.getNowDate();
		System.out.println("当前日期是："+date);
		CarInfo car = new CarInfo(carLisence,date);
		int i  = iCarInfoDao.partAddCar(car);
		if(i!=1){
			car = null;
		}
		return car;
	}
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月16日 上午11:31:49 
	* @version 1.0 
	* @parameter  String carLisence 车牌号
	* @description 从当前车场车辆表中删除车辆信息
	* @return  boolean
	*/
	public CarInfo deleteCar(String carLisence){
		String date = myDateUnitl.getNowDate();
		System.out.println("当前日期是："+date);
		CarInfo car = new CarInfo(carLisence,date);
		int i  = iCarInfoDao.partDeleteCar(car);
		if(i<1){
			car = null;
		}
		return car;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月16日 上午10:05:49 
	* @version 1.0 
	* @parameter  String str 车位情况:1、使用中；2、未使用；3、维护中
	* @description 查询当前车位情况
	* @return List<CarPort>
	*/
	public List<CarPort> searchCarPort(String str){
		List<CarPort> list = iCarInfoDao.searchUnusePort(iCarInfoDao.searchUnusePortParameter(str));
		return list;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月16日 上午10:36:49 
	* @version 1.0 
	* @description 上传文件处理并根据参数分类保存
	* @parameter  MultipartFile fileact
	* @parameter  ServletContext servletContext
	* @parameter  String param:1、入口；2、出口；3、入库；4、出库
	* @return String 图片最终存储地址，失败则返回null
	*/
	public String getImage(MultipartFile fileact, ServletContext servletContext ,String param){
		String filePath = null;//最终图片的地址
		//---------------------识别照片来源开始----------------------------//
		String path2 = null;
		if("入口".equals(param)){
			System.out.println("入口拍照");
			path2 = "/entranceImage";
		}else if("出口".equals(param)){
			System.out.println("出口拍照");
			path2 = "/exportImage";
		}else if("入库".equals(param)){
			System.out.println("入库拍照");
			path2 = "/storageImage";
		}else if("出库".equals(param)){
			System.out.println("出库拍照");
			path2 = "/outboundImage";
		}

		//---------------------识别照片来源结束----------------------------//
		String filename = fileact.getOriginalFilename();
		if(filename==null){
			System.out.println("文件为空");
			return filePath;
		}else if(filename.length()==0){
			System.out.println("文件为空");
			return filePath;
		}
		System.out.println("获取到的文件名:" + filename);
		if(filename.endsWith(".jpg")){
			System.out.println("符合要求");
			//将照片存放到相应的文件夹下
			String path = servletContext.getRealPath(path2);
			// 如果对应目录不存在就新建一个
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("目录不存在，新建文件夹:" + path2);
				file.mkdirs();
			}
			System.out.println(path);
			//对文件进行重新命名,用当前时间命名
			String date = myDateUnitl.getNowDate();
			System.out.println("当前日期是：" + date);
			String newFilename=date.replaceAll("[\\pP\\p{Punct}]","");//清除所有符号,只留下字母 数字  汉字  共3类.  
			newFilename = newFilename + ".jpg";
	        System.out.println("新文件名是：" + newFilename); 
	        System.out.println("处理前的路径是：" + path); 
	        path = path.replace("\\", "/");
	        System.out.println("处理后的路径是：" + path); 
	        
			try {
				fileact.transferTo(new File(path + "/" +newFilename));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			filePath = path + "/" +newFilename;//将写入的图片地址传入返回值
		}
		return filePath;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月16日 上午14:07:49 
	* @version 1.0 
	* @description 从车辆照片中识别车牌
	* @parameter  String filePath 图片地址
	* @return String 车牌字符串
	*/
	public String recognitionCarImage(String filePath){
		System.out.println("即将要识别的车牌文件路径是：" + filePath);
		
		System.out.println(System.getProperty("user.dir"));
		String classPath = this.getClass().getResource("/").getPath();
		System.out.println(classPath);
		
		String path2 = (this.getClass().getResource("").getPath() + "SVM/svm.xml").substring(1);
		System.out.println(path2);
		
		String carLicense = null;
		Mat src2 = opencv_imgcodecs.imread(filePath);
		carLicense = PlateRecognition.plateRecognise(src2);
		System.out.println("识别的车牌:"+carLicense);
		return carLicense;
	}
}
