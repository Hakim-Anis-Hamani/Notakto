package cstjean.mobile.notakto;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;


import android.os.RemoteException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;


@RunWith(AndroidJUnit4.class)
public class NotakoActivityInstrumentedTest {
    @Rule
    public ActivityScenarioRule<NotaktoActivity> rule = new ActivityScenarioRule<>(NotaktoActivity.class);

    @Test
    public void testResultat() throws RemoteException {

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.setOrientationLeft();

        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn2)).perform(click());



    }
}