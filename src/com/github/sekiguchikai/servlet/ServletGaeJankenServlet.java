package com.github.sekiguchikai.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.sekiguchikai.model.Janken;
import com.github.sekiguchikai.model.JankenLogic;

@SuppressWarnings("serial")
public class ServletGaeJankenServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JankenForm.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			System.err.println("エラー" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータを取得
		String clientUchite = request.getParameter("clientUchite");
		// クライアントの打ち手

		// 入力値をプロパティに設定
		Janken janken = new Janken();

		int intClientUchite = Integer.parseInt(clientUchite);

		// セッターで登録
		janken.setClientUchite(intClientUchite);

		// じゃんけんのロジックを実施
		JankenLogic jankenLogic = new JankenLogic();
		jankenLogic.judgeResult(janken);

		// リクエストスコープに保存
		request.setAttribute("janken", janken);

		try {
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("フォワードに失敗しました");
			e.printStackTrace();
		}

	}
}
