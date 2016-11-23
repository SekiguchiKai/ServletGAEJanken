package com.github.sekiguchikai.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JankenLogicTest {
	private final String GU = "グー";
	private final String TYOKI = "チョキ";
	private final String PA = "パー";

	/**
	 * judgeResultをテストするためのクラス
	 */
	@Test
	public void testudgeResult() {
		// 1.Jankenへ打ち手の登録
		Janken janken = new Janken();
		janken.setClientUchite(GU);
		janken.setServerUchite(TYOKI);
		JankenLogic jankenLogic = new JankenLogic();
		jankenLogic.judgeResult(janken);

		// 2.JankenLogicの呼び出し
		assertEquals("クライアントがグー, サーバーがチョキの場合のテスト", "君の勝ちだ", janken.getResult());

		// 1.Jankenへ打ち手の登録
		Janken janken2 = new Janken();
		janken2.setClientUchite(TYOKI);
		janken2.setServerUchite(PA);
		JankenLogic jankenLogic2 = new JankenLogic();
		jankenLogic2.judgeResult(janken2);

		// 2.JankenLogicの呼び出し
		assertEquals("クライアントがチョキ, サーバーがパーの場合のテスト", "君の勝ちだ", janken2.getResult());

		// 1.Jankenへ打ち手の登録
		Janken janken3 = new Janken();
		janken3.setClientUchite(PA);
		janken3.setServerUchite(GU);
		JankenLogic jankenLogic3 = new JankenLogic();
		jankenLogic3.judgeResult(janken3);

		// 2.JankenLogicの呼び出し
		assertEquals("クライアントがパー, サーバーがグーの場合のテスト", "君の勝ちだ", janken3.getResult());

		// 1.Jankenへ打ち手の登録
		Janken janken4 = new Janken();
		janken4.setClientUchite(TYOKI);
		janken4.setServerUchite(GU);
		JankenLogic jankenLogic4 = new JankenLogic();
		jankenLogic4.judgeResult(janken4);

		// 2.JankenLogicの呼び出し
		assertEquals("クライアントがチョキ, サーバーがグーの場合のテスト", "君の負けだ", janken4.getResult());

		// 1.Jankenへ打ち手の登録
		Janken janken5 = new Janken();
		janken5.setClientUchite(PA);
		janken5.setServerUchite(TYOKI);
		JankenLogic jankenLogic5 = new JankenLogic();
		jankenLogic5.judgeResult(janken5);

		// 2.JankenLogicの呼び出し
		assertEquals("クライアントがパー, サーバーがチョキの場合のテスト", "君の負けだ", janken5.getResult());

		// 1.Jankenへ打ち手の登録
		Janken janken6 = new Janken();
		janken6.setClientUchite(GU);
		janken6.setServerUchite(PA);
		JankenLogic jankenLogic6 = new JankenLogic();
		jankenLogic6.judgeResult(janken6);

		// 2.JankenLogicの呼び出し
		assertEquals("クライアントがグー, サーバーがパーの場合のテスト", "君の負けだ", janken6.getResult());

		String uchiteArray[] = { GU, TYOKI, PA };

		for (int i = 0; i < uchiteArray.length; i++) {

			// 1.Jankenへ打ち手の登録
			Janken janken7 = new Janken();
			janken7.setClientUchite(uchiteArray[i]);
			janken7.setServerUchite(uchiteArray[i]);
			JankenLogic jankenLogic7 = new JankenLogic();
			jankenLogic7.judgeResult(janken7);

			// 2.JankenLogicの呼び出し
			assertEquals("クライアントがグー, サーバーがチョキの場合のテスト", "引き分けだ", janken7.getResult());

		}

	}

}
