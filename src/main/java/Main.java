import com.emiliorodo.ad.sdk.AppdirectConnector;
import com.emiliorodo.ad.sdk.events.payloads.events.SubscriptionCancel;
import com.emiliorodo.ad.sdk.events.payloads.events.SubscriptionOrder;
import com.emiliorodo.ad.sdk.events.payloads.responses.SubscriptionCancelResponse;
import com.emiliorodo.ad.sdk.events.payloads.responses.SubscriptionOrderResponse;
import com.emiliorodo.ad.sdk.external.AppdirectConnectorBuilder;
import com.emiliorodo.ad.sdk.internal.events.handlers.EventHandler;

public class Main {

	public static void main(String[] args) {
		EventHandler<SubscriptionOrder, SubscriptionOrderResponse> subscriptionOrderHandler = event -> null;
		EventHandler<SubscriptionCancel, SubscriptionCancelResponse> subscriptionCancelHandler = event -> null;

		AppdirectConnector connector = new AppdirectConnectorBuilder(subscriptionOrderHandler, subscriptionCancelHandler)
			.build();

		connector.start();
	}
}
