package com.github.sekiguchikai.model;

public class JankenLogic {
	String result;
	int serverUchite;

	public void judgeResult(Janken janken) {

		// クライアントから送られてきたpostの値を元にフィールドを設定
		int clientUchite = (int) janken.getClientUchite();

		// サーバの打ち手を決める
		// Math.random()では、0.0 以上 1.0未満のdouble値を返すので 2倍して1を加算する
		Integer intServerUchite = (int) janken.getServerUchite();

		if (intServerUchite.equals(null)) {
			serverUchite = (int) (Math.random() * 2) + 1;
		} else {
			// オートボクシングを利用
			serverUchite = intServerUchite;
		}

		if (((clientUchite == 0) && (serverUchite == 1)) || ((clientUchite == 1) && (serverUchite == 2))
				|| ((clientUchite == 2) && (serverUchite == 0))) {
			result = "君の勝ちだ";
		} else if (((clientUchite == 1) && (serverUchite == 0)) || ((clientUchite == 2) && (serverUchite == 1))
				|| ((clientUchite == 0) && (serverUchite == 2))) {
			result = "君の負けだ";
		} else {
			result = "引き分けだ";
		}

		janken.setResult(result);
	}
}
