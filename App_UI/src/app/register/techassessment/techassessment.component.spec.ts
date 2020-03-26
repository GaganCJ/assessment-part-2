import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechassessmentComponent } from './techassessment.component';

describe('TechassessmentComponent', () => {
  let component: TechassessmentComponent;
  let fixture: ComponentFixture<TechassessmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TechassessmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechassessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
