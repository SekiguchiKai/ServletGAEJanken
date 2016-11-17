package com.github.sekiguchikai.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JankenLogicTest {
	private final int GU = 0;
	private final int THOKI = 1;
	private final int PA = 2;

	/**
	 * judgeResultをテストするためのクラス
	 */
	@Test
	public void testudgeResult() {
		// 1.Jankenへ打ち手の登録
		Janken janken = new Janken();
		janken.setClientUchite(GU);
		janken.setServerUchite(THOKI);
		JankenLogic jankenLogic = new JankenLogic();
		jankenLogic.judgeResult(janken);

		// 2.JankenLogicの呼び出し
		assertEquals("クライアントがグー, サーバーがチョキの場合のテスト", "君の勝ちだ", janken.getResult());
	}

}
