package org.auction.service;

import org.auction.service.requestresponse.RecordBidServiceRequest;
import org.auction.service.requestresponse.RecordBidServiceResponse;
import org.springframework.stereotype.Service;

/**
 * @author Kirankumar
 *
 */

@Service(value="recordBidService")
public class RecordBidService extends AbstractAuctionService<RecordBidServiceRequest,RecordBidServiceResponse> {

	@Override
	public RecordBidServiceResponse makeCall(RecordBidServiceRequest request) {
		return null;
	}


}
