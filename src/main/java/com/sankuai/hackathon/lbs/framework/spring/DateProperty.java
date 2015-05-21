package com.sankuai.hackathon.lbs.framework.spring;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Description: DateProperty
 * Author: liuzhao
 * Create: 2015-02-19 06:11
 */
public class DateProperty extends PropertyEditorSupport {
    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) {
        SimpleDateFormat sdf = new SimpleDateFormat(detectFormat(text));
        try {
            this.setValue(sdf.parse(text));
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String detectFormat(String source) {
        if (format == null) {
            String pattern;
            if (source.contains("T") && source.contains("+")) {
                pattern = "yyyy-MM-dd'T'HH:mm:ss'+08:00'";
            } else {
                if (source.contains(":")) {
                    pattern = "yyyy-MM-dd HH:mm:ss";
                } else {
                    pattern = "yyyy-MM-dd";
                }
            }
            return pattern;
        }
        return format;
    }
}
