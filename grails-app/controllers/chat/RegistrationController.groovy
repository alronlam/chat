package chat

class RegistrationController {

	def index() { }

	def join(String name){
		if (name.trim() == ''){
			redirect(action: 'index')
		}else{
			session.name = name
			session.ipAddress = getClientIPAddress()
			render(view: 'chat')
		}
	}

	def getClientIPAddress(){
		def ipAddress = request.getHeader("Client-IP")

		if (!ipAddress)
			ipAddress = request.getHeader("X-Forwarded-For")

		if (!ipAddress)
			ipAddress = request.getRemoteAddr()

		println 'IP ADDRESS is '+ipAddress

		return ipAddress
	}
}
