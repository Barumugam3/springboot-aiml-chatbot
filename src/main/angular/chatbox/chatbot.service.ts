import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ChatBotService {
  constructor(private http: HttpClient) { }
 
  sendRequest(message: string) {
	return this.http.get('http://10.32.234.122:9090/bot/send/'+message);
  }  
}
