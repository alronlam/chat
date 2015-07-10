<g:each in="${messages}" var="message">
    <div>
        <span class="nickname" style="display:inline-block; max-width:300px;min-width:70px"><strong>${message.name}</strong></span>:   <span class="msg">${message.content}</span>
    </div>
</g:each>