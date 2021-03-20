package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cart;
import bean.Items;
import dao.ItemsDAO;

/**
 * 购物车的Servlet
 * 
 * @author Administrator
 *
 */
public class CartServlet extends HttpServlet {

	private String action; // 表示购物车的动作 ,add,show,delete
	// 商品业务逻辑类的对象
	private ItemsDAO idao = new ItemsDAO();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) // 如果是添加商品进购物车
			{
				if (addToCart(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			if (action.equals("show"))// 如果是显示购物车
			{
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			if (action.equals("delete")) // 如果是执行删除购物车中的商品
			{
				if (deleteFromCart(request, response)) {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}

	}

	// 添加商品进购物车的方法
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = idao.getItemsById(Integer.parseInt(id));
		// 是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			return true;
		} else {
			return false;
		}

	}

	// 从购物车中删除商品
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Items item = idao.getItemsById(Integer.parseInt(id));// 获得要删除商品的id
		if (cart.removeGoodsFromCart(item)) {
			return true;
		} else {
			return false;
		}
	}
}
