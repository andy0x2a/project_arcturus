<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<% response.setHeader("X-UA-Compatible", "IE=edge, Chrome=1");%>
<%--<% response.setHeader("pragma", "no-cache");%>--%>
<%--<% response.setHeader("cache-control", "no-cache");%>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="64k" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%
    pageContext.setAttribute("advisorHeaderParamValue", ca.qtrade.common.utility.Constants.ADVISOR_WEB_GROUP_NAME);
    pageContext.setAttribute("headerParamValue", ca.qtrade.common.utility.Constants.INVESTOR_GROUP_NAME);
    pageContext.setAttribute("headerParamName", ca.qtrade.common.utility.Constants.COMPANY_GROUP_PARAMETER_NAME);
%>