package com.github.sekiguchikai.model;

import java.io.Serializable;

/**
 * リクエストスコープ じゃんけんに関する状態（インスタンス）を保存する
 * 
 * @author sekiguchikai
 * 
 */

public class Janken implements Serializable {

	private int clientUchite;
	private int serverUchite;
	private String result;

	/**
	 * クライアントの打ち手を他のクラスのインスタンスから取得するためのゲッター
	 * 
	 * @return クライアントの打ち手を返す
	 */
	public double getClientUchite() {
		return this.clientUchite;
	}

	/**
	 * クライアントの打ち手を他のクラスのインスタンスから設定するためのセッター
	 * 
	 * @param clientUchite
	 *            クライアントの打ち手
	 */
	public void setClientUchite(int clientUchite) {
		this.clientUchite = clientUchite;
	}

	/**
	 * サーバの打ち手を他のクラスのインスタンスから取得するためのゲッター
	 * 
	 * @return サーバの打ち手を返す
	 */
	public double getServerUchite() {
		return this.serverUchite;
	}

	/**
	 * サーバの打ち手を他のクラスのインスタンスから設定するためのセッター
	 * 
	 * @param serverUchite
	 *            クライアントの打ち手
	 */
	public void setServerUchite(int serverUchite) {
		this.serverUchite = serverUchite;
	}

	/**
	 * 他のクラスのインスタンスから、このクラスのresultを取得するためのゲッター
	 * 
	 * @return 勝負の結果の打ち手を返す
	 */
	public String getResult() {
		return this.result;
	}

	/**
	 * 他のクラスのインスタンスから、このクラスのresultを設定するためのセッター
	 * 
	 * @param result
	 *            勝負の結果
	 */
	public void setResult(String result) {
		this.result = result;
	}

}
