package homework;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
 
 
public class DecisionTree {
//	public static  void main(String []args){
	LinkedList<String[]> dataList = new LinkedList<String[]>();//����ѵ���������ݣ��ṹΪ�����+����+���
	LinkedList<String> attribute = new LinkedList<String>();//������Ը���
	DecisionTree father;
	String attriValue;
	String attriDivide;
	LinkedList<DecisionTree> child;
	HashMap<String,LinkedList<String>> attributeValue = new HashMap<String,LinkedList<String>>();//������Լ����Ӧ������ֵ
	public DecisionTree(String[][] data,HashMap<String,LinkedList<String>> attributeValue,DecisionTree father,String attriDivide,String attriValue) {
		this.father = father;
		this.attriDivide = attriDivide;
		this.attriValue = attriValue;
		this.attributeValue = attributeValue;
		getDataAndAttribute(data,attributeValue);
		if(!detectEnd()) {//��ǰ�ڵ㲻Ϊ��Ҷ�ڵ㣬���Լ������·�
			String attriRoot = bestAttri();//�õ���ǰ�Ļ�������
			Map<String,LinkedList<String[]>> child = divideByAttribute(attriRoot);//�õ����ֺ�����ж���
			this.child = new LinkedList<DecisionTree>();//���滮�ֵĽڵ����ڵ�ǰ�Ķ���
			//��ò�ͬ��ֵ��������ݼ����Ȼ�ȡ��ֵ��
			Set<String> keySet = child.keySet();
			//������ֵ��
			Iterator<String> keys = keySet.iterator();
			while(keys.hasNext()) {
				String key = keys.next();
				LinkedList<String[]> childData = child.get(key);//��ȡ�˼�ֵ������������ݼ�
				HashMap<String,LinkedList<String>> newAttribute = this.attributeValue;
				newAttribute.remove(attriRoot);
				if(childData.size()==0)continue;
				String[][] datas = new String[childData.size()][childData.get(0).length];//��child�����data��Ϊ��ά�������ʽ
				for(int i=0;i<childData.size();i++) {
					datas[i] = childData.get(i);
				}
				DecisionTree childNode = new DecisionTree(datas,newAttribute,this,attriRoot,key);
				this.child.add(childNode);
			}
		}
	}
	public void getDataAndAttribute(String[][] data,HashMap<String,LinkedList<String>> attribute) {
		for(int i=0;i<data.length;i++) {//���������ݼ�ѹ��������ݼ���
			this.dataList.add(data[i]);
		}
		Set<String> keySet = attribute.keySet();
		Iterator<String> it = keySet.iterator();//��map����ļ�ֵд�뵽���ص�attribute���У���Ϊ���Ա�
		while(it.hasNext()) {
			String s = it.next();
			this.attribute.add(s);
		}
	}
	boolean detectEnd() {//�жϵ�ǰ�ڵ��Ƿ�Ϊ��Ҷ�ڵ�
		Set<String> detect = new HashSet<String>();
		for(int i=0;i<dataList.size();i++) {
			String[] temp = dataList.get(i);
			detect.add(temp[temp.length-1]);
		}//�����з���������ֻ��һ�ֽ����������Ҷ�ڵ�
		if(detect.size()==1)return true;
		else return false;
	}
	double calEntropy(String attribute) {
		double result = 0;//��������ֵ����ֵ��
		double totalNum = this.dataList.size();//�����ݼ��ĸ���
		Map<String,LinkedList<String[]>> divide = divideByAttribute(attribute);//�õ�������attributeֵ����Ľ��
		Set<String> keySet = divide.keySet();//�õ����м�ֵ
		Iterator<String> iterator = keySet.iterator();//�������м�ֵ
		while(iterator.hasNext()) {
			String key = iterator.next();
			LinkedList<String[]> values = divide.get(key);//��õ�ǰ��ֵ�����е����ݼ�
			int count = values.size();//��ǰ��ֵ�µ����ݸ���
			Set<String> resultSet = new HashSet<String>();//ʹ��Set���жϽ�����ж�����
			for(int i=0;i<count;i++) {
				String[] temp = values.get(i);
				resultSet.add(temp[temp.length-1]);
			}
			Iterator<String> iteratorResult = resultSet.iterator();//�����������
			double resultInAttribute = 0;//��ǰ����ֵ�µ���ֵ
			int countI;
			while(iteratorResult.hasNext()) {
				countI=0;//���㲻ͬ��������ж�����
				String resultI = (String)iteratorResult.next();//��ǰ�Ľ��
				for(int i=0;i<count;i++) {
					String[] temp = values.get(i);//�����ݼ��еĽ���Ƚ�
					if(temp[temp.length-1].equals(resultI))countI++;//��������뵱ǰ�����ͬ��������һ
				}
				//����õ���ǰ����ֵ����
				resultInAttribute = resultInAttribute - ((double)countI/count)*(Math.log((double)countI/count)/Math.log(2));
			}
			result = result + ((double)count/totalNum)*resultInAttribute;
		}
		return result;
	}
	public String bestAttri() {
		double min = 100;
		String choose = "";
		for(int i=0;i<this.attribute.size();i++) {
			double cal = calEntropy(this.attribute.get(i));
			if(min>cal) {
				min = cal;
				choose = this.attribute.get(i);
			}
		}
		return choose;
	}
	Map<String,LinkedList<String[]>> divideByAttribute(String attribute){
		LinkedList<String> attriValue = this.attributeValue.get(attribute);//��õ�ǰ�����µ�����ֵ
		String[] content = this.dataList.get(0);//�ӱ�����������ó���0����Ϊ���жϵ�ǰ��attribute����һ��
		int col=0;
		for(int i=1;i<content.length-1;i++) {
			if(attriValue.contains(content[i])) {
				col = i;//�ҵ���ǰattribute���ڵ���
				break;
			}
		}
		Map<String,LinkedList<String[]>> result = new HashMap<String,LinkedList<String[]>>();//�����
		//���濪ʼ��attribute��ֵ��dataList����
		for(int i=0;i<attriValue.size();i++) {//����
			LinkedList<String[]> resultValue = new LinkedList<String[]>();//��ǰattribute[i]��ֵ
			for(int j=0;j<this.dataList.size();j++) {
				String[] temp = this.dataList.get(j);
				if(temp[col].equals(attriValue.get(i)))resultValue.add(temp);
			}
			if(resultValue.size()!=0)result.put(attriValue.get(i), resultValue);
		}
		return result;
	}
//}
	
}