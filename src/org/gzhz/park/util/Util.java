package org.gzhz.park.util;

import java.io.File;
import java.util.Vector;

import org.springframework.stereotype.Component;


/**
 * @author eguid
 *
 */

public class Util {

    /**
     * get all files under the directory path
     * 
     * @param path
     * @param files
     */
    public static void getFiles(final String path, Vector<String> files) {
        getFiles(new File(path), files);
    }

    /**
     * delete and create a new directory with the same name
     * 
     * @param dir
     */
    public static void recreateDir(final String dir) {
        new File(dir).delete();
        new File(dir).mkdir();
    }
    
    private static void getFiles(final File dir, Vector<String> files) {
        File[] filelist = dir.listFiles();
        for (File file : filelist) {
            if (file.isDirectory()) {
                getFiles(file, files);
            } else {
                files.add(file.getAbsolutePath());
            }
        }
    }
}
