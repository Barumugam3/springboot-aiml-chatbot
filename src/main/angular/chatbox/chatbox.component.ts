/* !-- */
import { Component, OnInit } from '@angular/core';
import { ChatBotService } from 'src/app/nextgen/components/chatbox/chatbot.service';

@Component({
  selector: 'aca-chatbox',
  templateUrl: './chatbox.component.html',
  styleUrls: ['./chatbox.component.scss'],
  providers: [ChatBotService]
})
export class ChatboxComponent implements OnInit{
  
  chatsession = [
    {source: 'receive', message:'Hi User'}
  ];
  inputfield:string;

  constructor(
	private chatService: ChatBotService
  ) {}
  ngOnInit() {
	
  }
  
  sendRequest(query: any){
	  this.chatsession.push({source: 'send', message:query});
	  this.chatService.sendRequest(query).subscribe((data: any) => {
		  console.log(data.response)
		  
		  if((data.response) !== ''){
			 if(((data.response).toString()).includes("Perhaps we should try a web search")){
				this.chatsession.push({source: 'receive', message:"None of the other robots can tell me the answer, Perhaps we should try a web search."});
			 }
			this.chatsession.push({source: 'receive', message:data.response});
		  }
		  this.inputfield = '';
	  });
  }
  
  resetChat(){
	this.chatsession = [];
	this.chatsession.push({source: 'receive', message:'Hi User'});
  }
  
}

