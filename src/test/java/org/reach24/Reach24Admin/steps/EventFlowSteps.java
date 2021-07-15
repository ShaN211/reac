package org.reach24.Reach24Admin.steps;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.reach24.Reach24Admin.pages.EventCreationPage;
import org.reach24.Reach24Admin.pages.EventInfoPage;
import org.reach24.Reach24Admin.pages.EventServicesPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Reach24AutomationCustomException;
import org.reach24.Reach24Admin.util.ReusableMethods;

import io.cucumber.datatable.DataTable;

public class EventFlowSteps extends BasePage {

	EventInfoPage eventInfoPage = new EventInfoPage(driver);
	EventCreationPage eventCreationPage = new EventCreationPage(driver);
	EventServicesPage eventServicePage = new EventServicesPage(driver);
	ReusableMethods reuse = new ReusableMethods();
	static String Drafteventid;

	public void assignEventToTenant(String action, String eventTenantType, String tenent, String payment) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eventInfoPage.clickFSC();
		eventInfoPage.searchFSC(tenent);
		eventInfoPage.clickAssignSP();

		if (action.equalsIgnoreCase("Reassign")) {

			eventInfoPage.reassignevent("Forwarded to Another Location");
		}

		if (payment.equalsIgnoreCase("Yes")) {

			if (eventTenantType.equalsIgnoreCase("Amazon")) {
				// eventInfoPage.selectAmazonPaymentMethod("cash");
				eventInfoPage.selectTireManufacturer("Bridgestone");
			} else {
				eventInfoPage.selectPaymentMethod("cash");
			}
			eventInfoPage.saveAndAssign();
		}

		// if(equipmentType.equalsIgnoreCase("chassis")) {
		// eventInfoPage.selectPaymentMethod("cash");
		// eventInfoPage.selectTireManufacturer("autotruck");
		// } else if(equipmentType.equalsIgnoreCase("trailer")) {
		// eventInfoPage.selectEquipmentInfoMake("Auto car");
		// eventInfoPage.enterEquipmentInfoModel("Mustang");
		// eventInfoPage.enterEquipmentInfoYear("2018");
		//
		// eventInfoPage.selectAssoTractorInfoMake("Ford");
		// eventInfoPage.enterAssoTractorInfoModel("Mustang");
		// eventInfoPage.enterAssoTractorInfoYear("2018");
		//
		// eventInfoPage.selectAssoTractorInfoEngineMake("cummins");
		// eventInfoPage.selectPaymentMethod("cash");
		// } else if(equipmentType.equalsIgnoreCase("container") ||
		// equipmentType.equalsIgnoreCase("powerunit")) {
		// eventInfoPage.selectEquipmentInfoMake("Ford");
		// eventInfoPage.enterEquipmentInfoModel("Mustang");
		// eventInfoPage.enterEquipmentInfoYear("2019");
		//
		// eventInfoPage.selectPaymentMethod("cash");
		// eventInfoPage.selectTireManufacturer("autotruck");
		//
		// }

		if (tenent.contains("NPSP")) {
			eventInfoPage.clickConfirmNPSP();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void acceptEvent(String action, String tenant) {
		try {
			switch (tenant.toUpperCase()) {

			case "TD":
				driver.get(PropsReader.tdEventInfoPage + EventCreationStep.eventInfoFromTenant.getEventId());
				break;

			case "AMAZON":
				driver.get(PropsReader.amazonEventInfoPage + EventCreationStep.eventInfoFromTenant.getEventId());
				break;

			case "SP":
				driver.get(PropsReader.spEventInfoPage + EventCreationStep.eventInfoFromTenant.getEventId());
				break;

			case "SP2":
				driver.get(PropsReader.sp2EventInfoPage + EventCreationStep.eventInfoFromTenant.getEventId());
				break;

			case "CC":
				driver.get(PropsReader.ccEventInfoPage + EventCreationStep.eventInfoFromTenant.getEventId());
				break;

			case "SCTECH":
				driver.get(PropsReader.sctechEventInfoPage + EventCreationStep.eventInfoFromTenant.getEventId());
				break;

			default:
				throw new Reach24AutomationCustomException("Invalid Accept Button");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(action.toLowerCase());
			switch (action.toLowerCase()) {

			case "accept":
				eventInfoPage.enterETA(reuse.getDate(+1));
				eventInfoPage.clickAcceptButton();
				break;

			case "reject":
				eventInfoPage.clickRejectButton();
				eventInfoPage.selectReasonToReject("Forwarded to Another Location");
				// eventInfoPage.acceptAlertButton();
				break;

			case "assigntech":
				eventInfoPage.clickAssignUserButton();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				eventInfoPage.selectTechnician("Test Tech");
				break;

			case "techaccept":
				eventInfoPage.techAccept();
				break;

			case "enroute":
				eventInfoPage.techEnroute();
				break;

			case "techrepair":
				eventInfoPage.techRepair();
				break;

			case "techarrive":
				eventInfoPage.techArrived();
				eventInfoPage.etcPOPUP();
				break;

			case "techdecline":
				eventInfoPage.clickDeclineButton();
				eventInfoPage.declineReason("Too far");
				break;

			case "complete":
				if (tenant.equals("CC")) {
					eventInfoPage.clickEditEvent();
					eventCreationPage.selectETA(reuse.getDate(+1));
					eventServicePage.clickSubmitButton();
				}
				eventInfoPage.clickCompleteButton();
				break;

			case "completeamazon":
				if (tenant.equals("CC")) {
					eventInfoPage.clickEditEvent();
					eventCreationPage.selectETA(reuse.getDate(+1));
					eventServicePage.clickSubmitButton();
				}
				eventInfoPage.clickCompleteButton();
				// eventInfoPage.clickAmazonCompleteButton();
				break;

			case "approve":
				eventInfoPage.clickApproveButton();
				break;

			case "repaire":
				eventInfoPage.clickRepairedButton();
				break;

			case "reprocess":
				eventInfoPage.clickReprocessButton();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				eventInfoPage.acceptAlertButton();
				break;

			case "estimate":
				eventInfoPage.clickEstimateButton();
				break;
				
			case "approveestimate":
				eventInfoPage.approveEstimate();
				break;

			case "rejectestimate":
				eventInfoPage.clickRejectEstimatesButton();
				break;
				
				
			default:
				throw new Reach24AutomationCustomException("Invalid Action");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}

	}

	public void prepareEstimate(DataTable estimates) {

		
		eventInfoPage.clickFindEstimateButton();
		
		
		List<Map<String, String>> list = estimates.asMaps(String.class, String.class);
		String estimateType;
		String amount;
		int totalGrossAmount = 0;
		int totalNetAmount = 0;
		int estimatedTotalAmount = 0;

		for (int i = 0; i <= list.size()-1; i++) {
			estimateType = list.get(i).get("Estimate");
			amount = list.get(i).get("Amount");

			try {
				System.out.println(estimateType.toLowerCase());
				System.out.println(amount);
				switch (estimateType.toLowerCase()) {

				case "discount":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalNetAmount = totalNetAmount - Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount - Integer.parseInt(amount);
					break;

				case "taxable":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					break;

				case "nontaxable":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					break;

				case "tax":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount) + Integer.parseInt(amount);
					break;

				case "parts":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "labor":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "oil":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "newtires":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "usedtires":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "tradein":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalNetAmount = totalNetAmount - Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount - Integer.parseInt(amount);
					break;

				case "sublet":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "roadcall":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "envwastetax":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				default:
					throw new Reach24AutomationCustomException("Invalid Action");

				}
			} catch (Reach24AutomationCustomException e) {
				e.printStackTrace();
			}
		}
		eventInfoPage.clickSubmitEstimatesButton();
		eventInfoPage.clickReviewEstimatesButton();
		String grossTot = eventInfoPage.getEstimates("totalGross");
		grossTot = grossTot.split(" ")[1];
		String grossNet = eventInfoPage.getEstimates("totalNet");
		grossNet = grossNet.split(" ")[1];
		String estimated = eventInfoPage.getEstimates("estimated");
		estimated = estimated.split(" ")[1];
		
		assertEquals(String.valueOf(totalGrossAmount).concat(".00"), grossTot.replace(",", ""));
		assertEquals(String.valueOf(totalNetAmount).concat(".00"), grossNet.replace(",", ""));
		assertEquals(String.valueOf(estimatedTotalAmount).concat(".00"), estimated.replace(",", ""));
		eventInfoPage.clickCloseEstimatesButton();
		
	}
	public void dummy() {
		System.out.println(eventInfoPage.getEstimates("totalGross").split(" ")[1].split(".")[0]);
	}

	public void assignTotech() {
		eventInfoPage.selectTechDropbox();
		eventInfoPage.clickAssigntechButton();
	}
	
	public void Deletedraftevent() throws InterruptedException, AWTException {
		eventCreationPage.selectdrafttab();
		eventCreationPage.remove();
		String eventnumber = eventCreationPage.extracteventid();
			eventCreationPage.searchdraft(eventnumber);
				Thread.sleep(3000);				
			eventCreationPage.action();
			eventCreationPage.deleteevent();
			eventCreationPage.klickokwarningpopup();
			wait.forLoading();
			if ((Drafteventid==null)) {
				System.out.println("Draft Event successfully deleted: " + eventnumber);
			}
}
}
