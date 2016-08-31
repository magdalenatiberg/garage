package service.getcar.business.api;

import java.math.BigDecimal;
import org.joda.time.DateTime;

public class Appointment {

	private DateTime startTime;
	private DateTime endTime;
	private DateTime reservationTime;
	private Errend errand;
	private String description;
	private BigDecimal price;
	
	public Appointment(Builder builder) {
		this.startTime = builder.startTime;
		this.endTime = builder.endTime;
		this.reservationTime = builder.reservationTime;
		this.errand = builder.errand;
		this.description = builder.description;
		this.price = builder.price;
	}
	
	public DateTime getStartTime() {
		return startTime;
	}
	public DateTime getEndTime() {
		return endTime;
	}
	public DateTime getReservationTime() {
		return reservationTime;
	}
	public Errend getErrand() {
		return errand;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	public static class Builder {
		private DateTime startTime;
		private DateTime endTime;
		private DateTime reservationTime;
		private Errend errand;
		private String description;
		private BigDecimal price;
		
		public Builder startTime(DateTime startTime) {
			this.startTime = startTime;
			return this;
		}
		
		public Builder endTime(DateTime endTime) {
			this.endTime = endTime;
			return this;
		}
		
		public Builder reservationTime(DateTime reservationTime) {
			this.reservationTime = reservationTime;
			return this;
		}
		
		public Builder errand(Errend errand) {
			this.errand = errand;
			return this;
		}

		public Builder errand(String description) {
			this.description = description;
			return this;
		}

		public Builder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		
		public Appointment build() {
			return new Appointment(this);
		}
	}
}
