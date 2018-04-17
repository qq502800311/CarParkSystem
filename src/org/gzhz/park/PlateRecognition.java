package org.gzhz.park;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.SampleModel;
import java.math.BigDecimal;
import java.util.Vector;

import org.bytedeco.javacpp.opencv_imgcodecs;
import org.gzhz.park.core.CharsRecognise;
import org.gzhz.park.core.PlateDetect;
import org.springframework.stereotype.Component;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.CvType;
import org.bytedeco.javacpp.opencv_core.CvTypeInfo;
import org.bytedeco.javacpp.opencv_core.Mat;



/**
 * 车牌识别
 * 
 * @author eguid
 *
 */

public class PlateRecognition {
	static PlateDetect plateDetect = null;
	static CharsRecognise cr = null;
	static {
		plateDetect = new PlateDetect();
		plateDetect.setPDLifemode(true);
		cr = new CharsRecognise();
	}

	/**
	 * 单个车牌识别
	 * 
	 * @param mat
	 * @return
	 */
	public static String plateRecognise(Mat mat) {
		Vector<Mat> matVector = new Vector<Mat>(1);
		if (0 == plateDetect.plateDetect(mat, matVector)) {
			if (matVector.size() > 0) {
				return cr.charsRecognise(matVector.get(0));
			}
		}
		return null;
	}

	/**
	 * 多车牌识别
	 * 
	 * @param mat
	 * @return
	 */
	public static String[] mutiPlateRecognise(Mat mat) {
		PlateDetect plateDetect = new PlateDetect();
		plateDetect.setPDLifemode(true);
		Vector<Mat> matVector = new Vector<Mat>(10);
		if (0 == plateDetect.plateDetect(mat, matVector)) {
			CharsRecognise cr = new CharsRecognise();
			String[] results = new String[matVector.size()];
			for (int i = 0; i < matVector.size(); ++i) {
				String result = cr.charsRecognise(matVector.get(i));
				results[i] = result;
			}
			return results;
		}
		return null;
	}

	/**
	 * 单个车牌识别
	 * 
	 * @param mat
	 * @return
	 */
	public static String plateRecognise(String imgPath) {
		Mat src = opencv_imgcodecs.imread(imgPath);
		return plateRecognise(src);
	}

	/**
	 * 多车牌识别
	 * 
	 * @param mat
	 * @return
	 */
	public static String[] mutiPlateRecognise(String imgPath) {
		Mat src = opencv_imgcodecs.imread(imgPath);
		return mutiPlateRecognise(src);
	}

	public static void main(String[] args) {
		
		//--------------------------自己写的使用方法开始---------------------------------//
//		String imgPath2 = "F:/ChuanYiJava/UTF8Mode/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/CarParkSystem/entranceImage/20180416 155439.jpg";
		
		String imgPath2 = "res/image/general_test/timg.jpg";
		Mat src2 = opencv_imgcodecs.imread(imgPath2);
		String ret2 = plateRecognise(src2);
		System.out.println("识别的车牌:"+ret2);
		//--------------------------自己写的使用方法结束---------------------------------//
//		int sum = 100;
//		int errNum = 0;
//		int sumTime = 0;
//		long longTime = 0;
//		for (int i = sum; i > 0; i--) {
//			 String imgPath = "res/train/data/plate_detect_svm/learn/HasPlate/A01_N84E28_0.jpg";
////			String imgPath = "res/image/test_image/core_func_yellow.jpg";
////			 String imgPath = "res/image/baidu_image/test3.jpg";
//			Mat src = opencv_imgcodecs.imread(imgPath);
//			long now = System.currentTimeMillis();
//			String ret = plateRecognise(src);
//			System.err.println(ret);
//			long s = System.currentTimeMillis() - now;
//			if (s > longTime) {
//				longTime = s;
//			}
//			sumTime += s;
//			if (!"苏EUK722".equals(ret)) {
//				errNum++;
//			}
//		}
//		System.out.println("总数量：" + sum);
//		System.out.println("单次最长耗时：" + longTime + "ms");
//
//		BigDecimal errSum = new BigDecimal(errNum);
//		BigDecimal sumNum = new BigDecimal(sum);
//		BigDecimal c = sumNum.subtract(errSum).divide(sumNum).multiply(new BigDecimal(100));
//		System.out.println("总耗时：" + sumTime + "ms,平均处理时长：" + sumTime / sum + "ms,错误数量：" + errNum + "，正确识别率：" + c + "%");
	}
}
