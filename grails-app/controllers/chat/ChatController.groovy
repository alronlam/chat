package chat

import message.Message

class ChatController {

	def retrieveLatestMessages() {
		def messages = Message.listOrderByDate(order: 'desc', max:10)
		[messages:messages.reverse()]
	}
	def submitMessage(String content) {
		new Message(name: session.name, content:content).save()
		render "<script>retrieveLatestMessages()</script>"
	}
}
