import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Oddevents
 */
@WebServlet("/oddevensort")
public class OddEvenSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OddEvenSort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int i, n;
        int[] array = new int[6];
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Oddevents</title>");
            out.println("</head>");
            out.println("<body>");

            for(i=0;i<6;i++)
            {
                String num=request.getParameter("no"+i);
                n=Integer.parseInt(num);
                array[i]=n;
            }
            out.println("Values Before the sort:\n\n");
            for (i = 0; i < array.length; i++) {
                out.println(array[i] + " \n ");
                
            }
            out.println();
            odd_even_srt(array, array.length);
            out.println("Values after the sort:\n\n");
            for (i = 0; i < array.length; i++) {
                out.println(array[i] + " \n ");
            }
            out.println();

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

     public static void odd_even_srt(int array[], int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j + 1 < n; j += 2) {
                if (array[j] > array[j + 1]) {
                    int T = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = T;
                }
            }
            for (int j = 1; j + 1 < array.length; j += 2) {
                if (array[j] > array[j + 1]) {
                    int T = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = T;
                }
            }
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//	processRequest(request,response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
		
	}

}
