package com.example.cliffhorwood.gedcomanalysis.Classes;

import java.io.File;
import java.io.FilenameFilter;

public class gedFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
            return (name.endsWith(".ged"));
    }
}
