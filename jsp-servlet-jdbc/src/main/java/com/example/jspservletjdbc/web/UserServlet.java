package com.example.jspservletjdbc.web;

import com.example.jspservletjdbc.dao.UserDao;
import com.example.jspservletjdbc.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * Servlet 是 Server Applet 的缩写，译为“服务器端小程序”，是一种使用
 * Java 语言来开发动态网站的技术。
 *
 * 您可以这样理解，Servlet 是 Sun 公司推出的一种基于 Java 的动态网站开发技术。
 * 编写 Servlet 代码需要遵循 Java 语法，一个 Servlet 程序其实就是一个按照
 * Servlet 规范编写的 Java 类。Servlet 程序需要先编译成字节码文件（.class文件），
 * 然后再部署到服务器运行。
 *
 * Servlet 规范是开放的，除了 Sun 公司，其它公司也可以实现 Servlet 规范，
 * 目前常见的实现了 Servlet 规范的产品包括 Tomcat、Weblogic、Jboss、WebSphere 等，
 * 它们都被称为“Servlet 容器”。Servlet 容器用来管理程序员编写的 Servlet 类。
 *
 * 创建servlet的方式 ：继承 HttpServlet 方法 或实现Servlet接口
 * 和 GenericServlet 类相比，HttpServlet 类更加方便，
 * 所以实际开发中一般都继承自 HttpServlet 类。
 * JSP 才是现代化的 Web 开发技术，它允许 HTML 代码和 JSP 代码分离，让程序员能够在 HTML 文档中直接嵌入 JSP 代码。
 * JSP 依赖于 Servlet，用户访问 JSP 页面时，JSP 代码会被翻译成 Servlet 代码
 * JSP 代码可以调用 Servlet 类，程序员可以将部分功能在 Servlet 中实现，然后在 JSP 中调用即可。
 *
 *
 * HttpServlet
 * HttpServlet 也是一个抽象类，它进一步继承并封装了 GenericServlet，
 * 使得使用更加简单方便，由于是扩展了 Http 的内容，所以还需要使用 HttpServletRequest
 * 和 HttpServletResponse，这两个类分别是 ServletRequest 和 ServletResponse 的子类。
 *
 * 在 HttpServlet 中，自定义了一个新的 service() 方法，其中通过 getMethod() 方法判断请求的类型，
 * 从而调用 doGet() 或者 doPost() 处理 get,post 请求
 *
 * 为了简化 Servlet 的配置，Servlet 3.0 中增加了注解支持，
 * 例如：@WebServlet、@WebInitParm 、@WebFilter 和 @WebLitener 等，
 * 这使得 web.xml 从 Servlet 3.0 开始不再是必选项了。
 *
 * Servlet 也有生命周期，Servlet 的生命周期就是 Servlet 从创建到销毁的过程：
 * 在 javax.servlet.Servlet 接口中定义了 3 个方法：init()、service()、destory()
 *
 * HttpServletRequest 和 HttpServletReponse 是 Servlet 处理 HTTP
 * 请求流程中最重要的两个对象。HttpServletRequest 对象用于封装 HTTP 请求信息，
 * HttpServletReponse 对象用于封装 HTTP 响应信息。
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public void init() {
        userDAO = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * doGet
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                   // deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    /**
     * 查询所有
     */
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // 1. 查询所有user
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    /**
     * 新增页面
     */
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
    /**
     * 修改页面
     */
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //1. 先获取当前的User信息
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        // 2. 修改页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }
    /**
     * 创建 User
     */
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        //1. request 获取参数
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        //2.调用Dao
        User newUser = new User(name, email, country);
        userDAO.insertUser(newUser);
        //3. response
        response.sendRedirect("list");
    }
    /**
     * 更新 User
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        //1. request 获取参数
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        //2.调用Dao
        User user = new User(id, name, email, country);
        userDAO.updateUser(user);
        //3. response
        response.sendRedirect("list");
    }

}
