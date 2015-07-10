package chat

import message.Message

class ChatController {

	def index(){
		if (!session.name)
			redirect(controller: 'registration')
	}

	def retrieveLatestMessages() {
		def messages = Message.listOrderByDate(order: 'desc', max:30)
		[messages:messages.reverse()]
	}
	def submitMessage(String content) {
		new Message(name: session.name, content:content).save()
		render "<script>retrieveLatestMessages()</script>"
	}
}
