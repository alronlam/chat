package chat

class RegistrationController {

	def index() { }

	def join(String name){
		if (name.trim() == ''){
			redirect(action: 'index')
		}else{
			session.name = name
			session.ipAddress = getClientIPAddress()
			redirect(controller: 'chat', params: [session: session])
		}
	}

	def getClientIPAddress(){
		def ipAddress = request.getHeader("Client-IP")

		if (!ipAddress)
			ipAddress = request.getHeader("X-Forwarded-For")

		if (!ipAddress)
			ipAddress = request.getRemoteAddr()

		return ipAddress
	}
}
