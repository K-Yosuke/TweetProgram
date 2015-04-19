package test.model.program;

/*
 * Web側から受け取った値から体型を算出して
 * bodyTypeを返却するクラス
 */
public class HealthCheckLogic {
  public void execute(Health health) {

    // BMIを算出して設定
    double weight = health.getWeight();
    double height = health.getHeight();
    double bmi = weight / (height / 100.0 * height / 100.0);
    health.setBmi(bmi);

    // BMIから体型を判定して設定
    String bodyType;

    // 体型判別用の変数を定義
    double thinBmi = 18.5;
    double obesityBmi = 25;

    if (bmi < thinBmi) {
      bodyType = "痩せ型";
    } else if (bmi < obesityBmi) {
      bodyType = "普通";
    } else {
      bodyType = "肥満";
    }

    health.setBodyType(bodyType);
  }

}
