package com.example.primecalc;

import static org.junit.Assert.assertEquals;

import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.w3c.dom.Text;

@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {

    private MainActivity mainActivity;

    @Before
    public void setUp(){
       mainActivity = Robolectric.buildActivity(MainActivity.class)
               .create()
               .start()
               .resume()
               .get();
    }

    @Test
    public void validateStartInt(){
        TextInputLayout textInputLayout = mainActivity.findViewById(R.id.start_int);
        assertEquals("start int",textInputLayout.getHint());
    }

    @Test
    public void validateEndInt(){
        TextInputLayout textInputLayout = mainActivity.findViewById(R.id.end_int);
        assertEquals("End Int",textInputLayout.getHint());
    }

    @Test
    public void validateButton(){
        Button button = mainActivity.findViewById(R.id.calculate);
        assertEquals("Calculate",button.getText());
    }
}
