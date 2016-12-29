
<%
    String menu = request.getParameter("go");
    if (menu == null || menu.equals("HomeFilm")) {

%>
<%@ include file="homefilm.jsp"%>

<%} else if (menu.equals("Kategori")) {
%>
<%@ include file="kategori.jsp"%>
<% } else if (menu.equals("DataFilm")) {
%>
<%@ include file="datafilm.jsp"%>
<%} else if (menu.equals("Customer")) {
%>
<%@ include file="customer.jsp"%>
<%} else if (menu.equals("PenyewaanFilm")) {
%>
<%@ include file="penyewaanfilm.jsp"%>
<%}else if (menu.equals("PenjualanFilm")){
%>
<%@ include file="penjualanfilm.jsp"%>
<%}else if (menu.equals("PengembalianFilm")){
%>
<%@ include file="pengembalianfilm.jsp"%>
<%}
%>