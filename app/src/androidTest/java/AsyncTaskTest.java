import android.os.AsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AsyncTaskTest {

    static class MyTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from doinbackground";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println("result:" + s);
        }
    }

    @Test
    public static void test() {
        new MyTask().execute("");
    }

}
