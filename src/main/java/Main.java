import java.util.Optional;

import com.github.emildafinov.ad.sdk.AppMarketConnector;
import com.github.emildafinov.ad.sdk.AppMarketConnectorBuilder;
import com.github.emildafinov.ad.sdk.AppMarketConnectorBuilderImpl;
import com.github.emildafinov.ad.sdk.EventHandler;
import com.github.emildafinov.ad.sdk.authentication.AppMarketCredentials;
import com.github.emildafinov.ad.sdk.authentication.AppMarketCredentialsSupplier;
import com.github.emildafinov.ad.sdk.event.payloads.SubscriptionCancel;
import com.github.emildafinov.ad.sdk.event.payloads.SubscriptionOrder;
import com.github.emildafinov.ad.sdk.event.responses.SubscriptionCancelResponse;
import com.github.emildafinov.ad.sdk.event.responses.SubscriptionOrderResponse;

public class Main {

	public static void main(String[] args) {
		EventHandler<SubscriptionOrder> subscriptionOrderHandler = (event, address) -> {};
		EventHandler<SubscriptionCancel> subscriptionCancelHandler = (event, address) -> {};

		AppMarketConnector connector = new AppMarketConnectorBuilderImpl(subscriptionOrderHandler, subscriptionCancelHandler, clientKey -> null)
			.build();

		connector.start();
	}
}
