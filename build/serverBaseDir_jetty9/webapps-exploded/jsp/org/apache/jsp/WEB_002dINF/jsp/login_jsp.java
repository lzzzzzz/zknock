package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>welcome</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/login.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/login.css\"/>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("/* base.scss */\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"htmleaf-container\">\r\n");
      out.write("  <p class=\"center\">welcome</p>\r\n");
      out.write("  <p class=\"center\"></p>\r\n");
      out.write("  <div id=\"wrapper\" class=\"login-page\">\r\n");
      out.write("    <div id=\"login_form\" class=\"form\">\r\n");
      out.write("      <form class=\"register-form\">\r\n");
      out.write("        <input type=\"text\" placeholder=\"用户名\" id=\"r_user_name\"/>\r\n");
      out.write("        <input type=\"password\" placeholder=\"密码\" id=\"r_password\" />\r\n");
      out.write("        <input type=\"text\" placeholder=\"电子邮件\" id=\"r_emial\"/>\r\n");
      out.write("        <button id=\"create\">创建账户</button>\r\n");
      out.write("        <p class=\"message\">已经有了一个账户? <a href=\"#\">立刻登录</a></p>\r\n");
      out.write("      </form>\r\n");
      out.write("      <form class=\"login-form\">\r\n");
      out.write("        <input type=\"text\" placeholder=\"用户名\" id=\"user_name\"/>\r\n");
      out.write("        <input type=\"password\" placeholder=\"密码\" id=\"password\"/>\r\n");
      out.write("        <button id=\"login\">登　录</button>\r\n");
      out.write("        <p class=\"message\">还没有账户? <a href=\"#\">立刻创建</a></p>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
