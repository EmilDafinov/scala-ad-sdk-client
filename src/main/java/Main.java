import com.github.emildafinov.ad.sdk.AppdirectConnector;
import com.github.emildafinov.ad.sdk.events.handlers.EventHandler;
import com.github.emildafinov.ad.sdk.events.payloads.events.SubscriptionCancel;
import com.github.emildafinov.ad.sdk.events.payloads.events.SubscriptionOrder;
import com.github.emildafinov.ad.sdk.events.payloads.responses.SubscriptionCancelResponse;
import com.github.emildafinov.ad.sdk.events.payloads.responses.SubscriptionOrderResponse;
import com.github.emildafinov.ad.sdk.external.AppdirectConnectorBuilder;

public class Main {

	public static void main(String[] args) {
		EventHandler<SubscriptionOrder, SubscriptionOrderResponse> subscriptionOrderHandler = event -> null;
		EventHandler<SubscriptionCancel, SubscriptionCancelResponse> subscriptionCancelHandler = event -> null;

		AppdirectConnector connector = new AppdirectConnectorBuilder(subscriptionOrderHandler, subscriptionCancelHandler)
			.build();

		connector.start();
	}
}
