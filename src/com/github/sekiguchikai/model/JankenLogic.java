package com.github.sekiguchikai.model;

public class JankenLogic {
	String result;
	String serverUchite;
	private final String GU = "グー";
	private final String TYOKI = "チョキ";
	private final String PA = "パー";

	public void judgeResult(Janken janken) {

		// クライアントから送られてきたpostの値を元にフィールドを設定
		String clientUchite = janken.getClientUchite();

		// サーバの打ち手を決める
		// Math.random()では、0.0 以上 1.0未満のdouble値を返すので 2倍して1を加算する
		String ServerUchite = janken.getServerUchite();

		// サーバ側の打ち手を決定
		if (ServerUchite == null) {
			int tempo = (int) (Math.random() * 2) + 1;
			if (tempo == 0) {
				serverUchite = GU;
			} else if (tempo == 0) {
				serverUchite = TYOKI;
			} else {
				serverUchite = PA;
			}
		}

		janken.setServerUchite(serverUchite);

		if (((clientUchite.equals(GU)) && (serverUchite.equals(TYOKI)))
				|| ((clientUchite.equals(TYOKI)) && (serverUchite.equals(PA)))
				|| ((clientUchite.equals(PA)) && (serverUchite.equals(GU)))) {
			result = "君の勝ちだ";
		} else if (((clientUchite == TYOKI) && (serverUchite.equals(GU)))
				|| ((clientUchite.equals(PA)) && (serverUchite == TYOKI))
				|| ((clientUchite.equals(GU)) && (serverUchite.equals(PA)))) {
			result = "君の負けだ";
		} else {
			result = "引き分けだ";
		}

		System.out.println("クライアントの打ち手は" + clientUchite + "サーバの打ち手は" + serverUchite + "結果は" + result);
		janken.setServerUchite(ServerUchite);
		janken.setClientUchite(clientUchite);
		janken.setResult(result);
	}
}
