package test.scope.servlet.program;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.model.program.Health;
import test.model.program.HealthCheckLogic;

/**
 * Servlet implementation class FowardServlet
 */
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub

    // Foward
    RequestDispatcher dispatcher = request
        .getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    // リクエストパラメータを取得
    String weight = request.getParameter("weight");
    String height = request.getParameter("height");

    // 入力値をプロパティに設定
    Health health = new Health();
    health.setHeight(Double.parseDouble(height));
    health.setWeight(Double.parseDouble(weight));

    // 健康診断を実行し結果を設定
    HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
    healthCheckLogic.execute(health);

    // リクエストスコープに保存
    request.setAttribute("health", health);

    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthCheckResult.jsp");
    dispatcher.forward(request, response);
  }
}
