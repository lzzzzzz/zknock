package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class socketTalk_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>WebSocket/SockJS Echo Sample (Adapted from Tomcat's echo sample)</title>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/sockjs.main.js\"></script>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        /*var  wsServer = 'ws://127.0.0.1:8080/test/hello';\n");
      out.write("        var  websocket = new WebSocket(wsServer);\n");
      out.write("        websocket.onopen = function (evt) { onOpen(evt) };\n");
      out.write("        websocket.onclose = function (evt) { onClose(evt) };\n");
      out.write("        websocket.onmessage = function (evt) { onMessage(evt) };\n");
      out.write("        websocket.onerror = function (evt) { onError(evt) };\n");
      out.write("        function onOpen(evt) {\n");
      out.write("           console.log(\"Connected to WebSocket server.\");\n");
      out.write("        }\n");
      out.write("        function onClose(evt) {\n");
      out.write("           console.log(\"Disconnected\");\n");
      out.write("        }\n");
      out.write("        function onMessage(evt) {\n");
      out.write("           console.log('Retrieved data from server: ' + evt.data);\n");
      out.write("        }\n");
      out.write("        function onError(evt) {\n");
      out.write("           console.log('Error occured: ' + evt.data);\n");
      out.write("        }*/\n");
      out.write("        var sock = new SockJS('http://192.168.2.34:8081/zknock-js/play');\n");
      out.write("        sock.onopen = function() {\n");
      out.write("            console.log('open');\n");
      out.write("            sock.send('哈哈哈哈哈哈');\n");
      out.write("            setTimeout(function(){sock.send('later');},3000);\n");
      out.write("        };\n");
      out.write("        sock.onmessage = function(e) {\n");
      out.write("\n");
      out.write("            console.log('message', e.data);\n");
      out.write("        };\n");
      out.write("        /*sock.onclose = function() {\n");
      out.write("            console.log('close');\n");
      out.write("        };*/\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
