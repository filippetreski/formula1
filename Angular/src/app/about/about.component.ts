import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute } from '@angular/router';
import { map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  abstract: String;
  language;
  constructor(private api: ApiService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.paramMap.pipe(
      map(it=> it.get('language')),
      switchMap(it => this.api.getFOneAbstract(`${it}`))
      ).subscribe(result => this.abstract = result[0].abstract.value);
  }

}
