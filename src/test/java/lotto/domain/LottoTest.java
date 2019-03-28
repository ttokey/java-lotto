package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Integer[] lottoNumber;
    private Integer[] lottoNumber2;
    private Integer[] winningNumber;

    @Before
    public void setUp() throws Exception {
        lottoNumber = new Integer[]{1, 2, 3, 4, 5, 6};
        lottoNumber2 = new Integer[]{1, 2, 3, 4, 9, 11};
        winningNumber = new Integer[]{1, 2, 3, 4, 5, 10};
    }

    @Test
    public void 로또생성() {
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumber);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    public void 당첨결과_일치하는숫자갯수() {
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumber));
        LottoNumbers luckyNumbers = new LottoNumbers(winningNumber);
        int result = lotto.matchCount(luckyNumbers);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void n장의_당첨결과_일치하는숫자갯수() {
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumber));
        Lotto lotto2 = new Lotto(new LottoNumbers(lottoNumber2));
        LottoNumbers luckyNumbers = new LottoNumbers(winningNumber);
        int result = lotto.matchCount(luckyNumbers);
        assertThat(result).isEqualTo(5);
        result = lotto2.matchCount(luckyNumbers);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void lotto의_당첨금() {
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumber));
        LottoNumbers luckyNumbers = new LottoNumbers(winningNumber);
        int result = lotto.getPrize(luckyNumbers).getPrize();
        assertThat(result).isEqualTo(1500000);
    }

    @Test
    public void lotto의_등수() {
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumber));
        LottoNumbers luckyNumbers = new LottoNumbers(winningNumber);
        int result = lotto.getRank(luckyNumbers).getRank();
        assertThat(result).isEqualTo(2);
    }

}