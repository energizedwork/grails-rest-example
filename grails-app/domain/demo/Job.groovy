package demo

class Job implements Serializable {

	String name
	String url

	String getResourceId() {
		"job/$id"
	}
		
}
