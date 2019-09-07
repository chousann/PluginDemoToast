package cordova.plugin.plugindemo.toast;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Toast;
import android.view.Gravity;

/**
 * This class echoes a string called from JavaScript.
 */
public class PluginDemoToast extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            String position = args.getString(1);
            this.coolMethod(message, position, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, String position, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            Toast t = Toast.makeText(cordova.getContext(), message, Toast.LENGTH_SHORT);
            switch(position) {
                case "top":
                    t.setGravity(Gravity.TOP, 0, 0);
                    break;
                case "center":
                    t.setGravity(Gravity.CENTER, 0, 0);
                    break;
                case "bottom":
                default:
                    t.setGravity(Gravity.BOTTOM, 0, 0);
                    break;
            }
            t.show();
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
