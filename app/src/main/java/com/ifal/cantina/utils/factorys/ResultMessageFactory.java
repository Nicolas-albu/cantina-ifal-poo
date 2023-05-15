package com.ifal.cantina.utils.factorys;

import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.views.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Factory class for generating result messages based on the type of view.
 *
 * @author Nicolas Albuquerque R.
 * @see AView
 */
public class ResultMessageFactory {

    /**
     * Gets the result message based on the provided view.
     *
     * @param view the view for which the result message is generated.
     * @return the result message.
     */
    public static String getResultMessage(AView view) {
        Map<Class<? extends AView>, String> resultMessages = new HashMap<>() {
            {
                put(View.class, "result.conclusion");
                put(ItemRegisterView.class, "result.insert");
                put(ItemRemovalView.class, "result.delete");
            }
        };

        String keyPropertyOfResultMessage = resultMessages.get(view.getClass());

        return ReadProperties.getProperty(keyPropertyOfResultMessage);
    }
}
