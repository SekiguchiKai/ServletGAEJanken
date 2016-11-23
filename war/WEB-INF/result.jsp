<%@page import="com.github.sekiguchikai.model.Janken"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// リクエストスコープに保存済みのJankenインスタンスの取得
Janken janken = (Janken) request.getAttribute("Janken");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>じゃんけん勝負の結果</title>
</head>
<body>
<h1>じゃんけんの結果</h1>
<p>君の打ち手は</p><%= janken.getClientUchite() %>
</body>
</html>