<g:each in="${messages}" var="message">
    <div>
        <span class="nickname">${message.name}</span> - <span class="msg">${message.content}</span>
    </div>
</g:each>