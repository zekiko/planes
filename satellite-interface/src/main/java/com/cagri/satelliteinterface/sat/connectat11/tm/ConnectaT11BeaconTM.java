package com.cagri.satelliteinterface.sat.connectat11.tm;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder
public class ConnectaT11BeaconTM{
  private int uptimeInSeconds; // uint32-t
  private float batterVoltage;
  private int temperature; // int32-t
  private int totalTxMessageCount; // uint32-t
  private int totalRXMessageCount; // uint32-t

  public long getUptimeInSeconds() {
    return this.uptimeInSeconds & 0xffffffffL;
  }

  public void setUptimeInSeconds(long uptimeInSeconds) {
    this.uptimeInSeconds = (int) (uptimeInSeconds & 0xffffffffL);
  }

  public long getTotalTxMessageCount() {
    return totalTxMessageCount & 0xffffffffL;
  }

  public void setTotalTxMessageCount(long totalTxMessageCount) {
    this.totalTxMessageCount = (int) (totalTxMessageCount & 0xffffffffL);
  }

  public long getTotalRXMessageCount() {
    return totalRXMessageCount & 0xffffffffL;
  }

  public void setTotalRXMessageCount(long totalRXMessageCount) {
    this.totalRXMessageCount = (int) (totalRXMessageCount & 0xffffffffL);
  }
}
