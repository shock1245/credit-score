package diplom;

import java.util.ArrayList;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.CostMatrix;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class machine_learn {
	
	static Classifier targetFunction;
	static Instances trainingDataset;
	static ArrayList<Attribute> attributes;
	static ArrayList<String> checking_status_values, credit_history_values, purpose_values, savings_status_values, employment_values, personal_status_values, other_parties_values, property_magnitude_values, other_payment_plans_values, housing_values, job_values, own_telephone_values, foreign_worker_values;
	static ArrayList<String> class_values;
	static Instance prdedictInstance;
	static Instances predictionDataset;
	static Attribute checking_status, duration, credit_history, purpose, credit_amount, savings_status, employment, installment_commitment, personal_status, other_parties, residence_since, property_magnitude, age, other_payment_plans, housing, existing_credits, job, num_dependents, own_telephone, foreign_worker, class_;
	static String prediction;
	
	machine_learn(){
		try {
			
			Random random = new Random();
			CostMatrix costMatrix = new CostMatrix(2);
			costMatrix.setElement(0, 0, 0);
			costMatrix.setElement(0, 1, 1.0);
			costMatrix.setElement(1, 0, 5.0);
			costMatrix.setElement(1, 1, 0);
			
			trainingDataset = DataSource.read("C:\\Users\\Nikita\\Desktop\\универ\\diplom\\diplom_prog\\german_train.arff");
			trainingDataset.setClassIndex(trainingDataset.numAttributes() - 1);
			if (diplom.jcbx.getSelectedIndex() == 2) {
				trainingDataset.setAttributeWeight(2, 1.4); //credit_history
				trainingDataset.setAttributeWeight(3, 0.6); //purpose
				trainingDataset.setAttributeWeight(5, 1.4); //savings_status
				trainingDataset.setAttributeWeight(6, 1.6); //employment
				trainingDataset.setAttributeWeight(8, 1.2); //pesonal_status
				trainingDataset.setAttributeWeight(10, 1.2); //residence_since
				trainingDataset.setAttributeWeight(11, 1.6); //property_magnitude
				trainingDataset.setAttributeWeight(14, 0.6); //housing
				trainingDataset.setAttributeWeight(16, 1.4); //job
			}else {
				if(diplom.jcbx.getSelectedIndex() == 3) {
					trainingDataset.setAttributeWeight(3, 0.6);
					trainingDataset.setAttributeWeight(5, 1.2);
					trainingDataset.setAttributeWeight(6, 1.2);;
					trainingDataset.setAttributeWeight(10, 1.2);
					trainingDataset.setAttributeWeight(11, 1.2);
					trainingDataset.setAttributeWeight(13, 1.2);
					trainingDataset.setAttributeWeight(14, 1.2);
					trainingDataset.setAttributeWeight(16, 1.2);
				}
			}
			System.out.println(trainingDataset.allAttributeWeightsIdentical());
			
			targetFunction = new NaiveBayes();
			targetFunction.buildClassifier(trainingDataset);
			
			Evaluation evaluation = new Evaluation(trainingDataset, costMatrix);
			evaluation.crossValidateModel(targetFunction, trainingDataset, 20, random);
			System.out.println(evaluation.toSummaryString("Results", false));
			}catch(Exception e1){
				e1.printStackTrace();
				}
		}
	
	static void machine_predict(){
		try {
			attributes = new ArrayList<>();
			checking_status_values = new ArrayList<>();
			checking_status_values.add("<0");
			checking_status_values.add("0<=X<9000");
			checking_status_values.add(">=9000");
			checking_status = new Attribute("checking_status", checking_status_values);
			
			duration = new Attribute("duration");
			
			credit_history_values = new ArrayList<>();
			credit_history_values.add("no credits/all paid");
			credit_history_values.add("all paid");
			credit_history_values.add("existing paid");
			credit_history_values.add("delayed previously");
			credit_history_values.add("critical/other existing credit");
			credit_history = new Attribute("credit_history", credit_history_values);
			
			purpose_values = new ArrayList<>();
			purpose_values.add("new car");
			purpose_values.add("used car");
			purpose_values.add("furniture/equipment");
			purpose_values.add("radio/tv");
			purpose_values.add("domestic appliance");
			purpose_values.add("repairs");
			purpose_values.add("education");
			purpose_values.add("vacation");
			purpose_values.add("retraining");
			purpose_values.add("business");
			purpose_values.add("other");
			purpose = new Attribute("purpose", purpose_values);
			
			credit_amount = new Attribute("credit_amount");
			
			savings_status_values = new ArrayList<>();
			savings_status_values.add("<100");
			savings_status_values.add("100<=X<500");
			savings_status_values.add("500<=X<1000");
			savings_status_values.add(">=1000");
			savings_status_values.add("no known savings");
			savings_status = new Attribute("savings_status", savings_status_values);
			
			employment_values = new ArrayList<>();
			employment_values.add("unemployed");
			employment_values.add("<1");
			employment_values.add("1<=X<4");
			employment_values.add("4<=X<7");
			employment_values.add(">=7");
			employment = new Attribute("employment", employment_values);
			
			installment_commitment = new Attribute("installment_commitment");
			
			personal_status_values = new ArrayList<>();
			personal_status_values.add("male div/sep");
			personal_status_values.add("female div/dep/mar");
			personal_status_values.add("male single");
			personal_status_values.add("male mar/wid");
			personal_status_values.add("female single");
			personal_status = new Attribute("personal_status", personal_status_values);
			
			other_parties_values = new ArrayList<>();
			other_parties_values.add("none");
			other_parties_values.add("co applicant");
			other_parties_values.add("guarantor");
			other_parties = new Attribute("other_parties", other_parties_values);
			
			residence_since = new Attribute("residence_since");
			
			property_magnitude_values = new ArrayList<>();
			property_magnitude_values.add("real estate");
			property_magnitude_values.add("life insurance");
			property_magnitude_values.add("car");
			property_magnitude_values.add("no known property");
			property_magnitude = new Attribute("property_magnitude", property_magnitude_values);
			
			age = new Attribute("age");
			
			other_payment_plans_values = new ArrayList<>();
			other_payment_plans_values.add("bank");
			other_payment_plans_values.add("stores");
			other_payment_plans_values.add("none");
			other_payment_plans = new Attribute("other_payment_plans", other_payment_plans_values);
			
			housing_values = new ArrayList<>();
			housing_values.add("rent");
			housing_values.add("own");
			housing_values.add("for free");
			housing = new Attribute("housing", housing_values);
			
			existing_credits = new Attribute("existing_credits");
			
			job_values = new  ArrayList<>();
			job_values.add("unemp/unskilled non res");
			job_values.add("unskilled resident");
			job_values.add("skilled");
			job_values.add("high qualif/self emp/mgmt");
			job = new Attribute("job", job_values);
			
			num_dependents = new Attribute("num_dependents");
			
			own_telephone_values = new ArrayList<>();
			own_telephone_values.add("none");
			own_telephone_values.add("yes");
			own_telephone = new Attribute("own_telephone", own_telephone_values);
			
			foreign_worker_values = new ArrayList<>();
			foreign_worker_values.add("yes");
			foreign_worker_values.add("no");
			foreign_worker = new Attribute("foreign_worker", foreign_worker_values);
			
			class_values = new ArrayList<>();
			class_values.add("good");
			class_values.add("bad");
			class_ = new Attribute("class", class_values);
			
			attributes.add(checking_status);
			attributes.add(duration);
			attributes.add(credit_history);
			attributes.add(purpose);
			attributes.add(credit_amount);
			attributes.add(savings_status);
			attributes.add(employment);
			attributes.add(installment_commitment);
			attributes.add(personal_status);
			attributes.add(other_parties);
			attributes.add(residence_since);
			attributes.add(property_magnitude);
			attributes.add(age);
			attributes.add(other_payment_plans);
			attributes.add(housing);
			attributes.add(existing_credits);
			attributes.add(job);
			attributes.add(num_dependents);
			attributes.add(own_telephone);
			attributes.add(foreign_worker);
			attributes.add(class_);
			
			predictionDataset = new Instances("predictionSet", attributes, 1);
			predictionDataset.setClassIndex(trainingDataset.numAttributes() - 1);
			prdedictInstance = new DenseInstance(20);
			
			prdedictInstance.setValue(checking_status, port_creadit.targetAttrib[0]);
			prdedictInstance.setValue(duration, Integer.parseInt(port_creadit.targetAttrib[17]));
			prdedictInstance.setValue(credit_history, port_creadit.targetAttrib[1]);
			prdedictInstance.setValue(purpose, port_creadit.targetAttrib[2]);
			prdedictInstance.setValue(credit_amount, Integer.parseInt(port_creadit.targetAttrib[16]));
			prdedictInstance.setValue(savings_status, port_creadit.targetAttrib[3]);
			prdedictInstance.setValue(employment, port_creadit.targetAttrib[4]);
			prdedictInstance.setValue(installment_commitment, Integer.parseInt(port_creadit.targetAttrib[18]));
			prdedictInstance.setValue(personal_status, port_creadit.targetAttrib[5]);
			prdedictInstance.setValue(other_parties, port_creadit.targetAttrib[6]);
			prdedictInstance.setValue(residence_since, Integer.parseInt(port_creadit.targetAttrib[13]));
			prdedictInstance.setValue(property_magnitude, port_creadit.targetAttrib[7]);
			prdedictInstance.setValue(age, Integer.parseInt(port_creadit.targetAttrib[14]));
			prdedictInstance.setValue(other_payment_plans, port_creadit.targetAttrib[8]);
			prdedictInstance.setValue(housing, port_creadit.targetAttrib[9]);
			prdedictInstance.setValue(existing_credits, Integer.parseInt(port_creadit.targetAttrib[15]));
			prdedictInstance.setValue(job, port_creadit.targetAttrib[10]);
			prdedictInstance.setValue(num_dependents, Integer.parseInt(port_creadit.targetAttrib[19]));
			prdedictInstance.setValue(own_telephone, port_creadit.targetAttrib[11]);
			prdedictInstance.setValue(foreign_worker, port_creadit.targetAttrib[12]);
			
			predictionDataset.add(prdedictInstance);
			
			int idx = (int) targetFunction.classifyInstance(predictionDataset.get(0));
			prediction = class_values.get(idx);
			}catch(Exception e1) {
				e1.printStackTrace();
				}
		}

}
