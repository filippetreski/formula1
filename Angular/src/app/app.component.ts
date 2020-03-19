import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Formula One';
  language = 'en';

  constructor(private route: ActivatedRoute, private router: Router){
  }

  onChangeLanguage(language: string){
      this.router.navigateByUrl(this.router.url.replace(this.language,language))
      this.language = language;
  }
}
