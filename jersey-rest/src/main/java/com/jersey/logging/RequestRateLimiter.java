package com.jersey.logging;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.atlassian.guava.common.util.concurrent.RateLimiter;

public class RequestRateLimiter { 
	 
	private final int numRequests;
	private final RateLimiter throttler;
	private final Logger logger = Logger.getLogger(RequestRateLimiter.class.getName());
 
	private int requestCounter;
	 
	/** 
	 *  
	 * @param numRequests - the number of allowed requests in the given time frame. 
	 * @param timeFrame - the timeframe limit for number of requests 
	 * @param unit - time unit. 
	 */ 
	public RequestRateLimiter(final int numRequests, final long timeFrame, final TimeUnit unit) {
		this.numRequests = numRequests;
		this.throttler = RateLimiter.create(1.0 / unit.toSeconds(timeFrame));
	} 
 
	/** 
	 * initializes the request rate limiter upon first block request in rotation.  
	 */ 
	private void init() { 
		boolean acquired = this.throttler.tryAcquire();
		if (acquired) {
			this.throttler.acquire();
		} 
	} 
	 
	/** 
	 *  
	 * @return true if blocking was preformed. 
	 */ 
	public boolean block() { 
		incrementRetryCounter(); 
		if (isInitRequired()) { 
			init(); 
		} 
		if (isThrottlingRequired()) { 
			logger.fine("Request limit has been reached. Rate limit is being enforced.");
			throttler.acquire();
			logger.fine("Rate limit enforcement has ended.");
			return true; 
		} 
		return false; 
	} 
	 
	// is this the first block attempt in the rotation? 
	private boolean isInitRequired() { 
		if ((this.requestCounter % this.getNumRequests()) == 1) {
			return true; 
		} 
		return false; 
	} 
 
	/** 
	 *  
	 * @return true if blocking is required. 
	 */ 
	public boolean tryBlock() { 
		return isThrottlingRequired(); 
	} 
 
	private boolean isThrottlingRequired() { 
		if ((this.requestCounter % this.getNumRequests()) == 0) {
			return true; 
		} 
		return false; 
	} 
 
	private synchronized void incrementRetryCounter() { 
		this.requestCounter = this.requestCounter + 1;
	} 
	 
	/** 
	 * Returns the defined duration for consequtive requests. 
	 *  
	 * @return the defined duration for consequtive requests. 
	 */ 
	public long getDuration() { 
		return (long) (1.0 / this.throttler.getRate());
	} 
 
	public int getNumRequests() { 
		return numRequests;
	} 
	 
	/** 
	 * returns the remaining retries until block. 
	 *  
	 * @return  
	 * 		remaining retries until block. 
	 */ 
	public int getRemainingRetries() { 
		return numRequests - (this.requestCounter % numRequests);
	} 
} 