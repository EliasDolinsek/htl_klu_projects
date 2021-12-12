package at.htlklu.mqttColorDisplay.infrastructure;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import at.htlklu.mqttColorDisplay.domain.MqttColor;
import at.htlklu.mqttColorDisplay.domain.OnColorChanged;

public class MqttDataSource implements Runnable, MqttCallback {
	
	private static final String BROKER = "tcp://iotmqtt.htl-klu.at:1883";
	private static final String CLIENT_ID = "mqtt_dolinsek";
	
	private OnColorChanged onColorChanged;
	
	
	public MqttDataSource(OnColorChanged onColorChanged) {
		this.onColorChanged = onColorChanged;
	}



	public void run() {
		try {
			 MqttClient client = new MqttClient(BROKER, CLIENT_ID);
			 client.setCallback(this);
			  
			 MqttConnectOptions options = new MqttConnectOptions();
			 options.setUserName("htl-IoT");
			 options.setPassword("iot..2015".toCharArray());
			 client.connect(options);
			  
			 client.subscribe("htl/3xhel/sub");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}



	public void connectionLost(Throwable cause) {
		
	}


	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String messageAsStr = message.toString();
		if(messageAsStr.equals("red")) {
			onColorChanged.onColorChanged(MqttColor.RED);
		} else if(messageAsStr.equals("green")) {
			onColorChanged.onColorChanged(MqttColor.GREEN);
		} else if(messageAsStr.equals("blue")){
			onColorChanged.onColorChanged(MqttColor.BLUE);
		}
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}
	
}
