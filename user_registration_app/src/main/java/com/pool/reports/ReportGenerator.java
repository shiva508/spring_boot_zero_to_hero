package com.pool.reports;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReportGenerator {
public void preparePdf(HttpServletRequest request,HttpServletResponse response);
}
