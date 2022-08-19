import React from "react";

import pic from "./assets/img/undraw_product_iteration_kjok.svg";
import pic1 from "./assets/img/undraw_Web_developer_re_h7ie.svg";
import pic2 from "./assets/img/icons.svg#icon-monitor";
import pic3 from "./assets/img/undraw_events_2p66.svg";
import {Button} from "reactstrap";
import pic4 from"./assets/img/undraw_survey_05s5.svg";




function Home() {


  return (
    <div>
      <div class="container">
        <div class="header__title">
          <div className="row">
            <div className="col-xs-6">
              <h1>
                Managing claims
                <br />
                <span class="highlight">made easy</span>
              </h1>
              <h4>A simple claim manager for a simple life.</h4>
              <button class="btn--text" >
                Learn more &DownArrow;
              </button>
            </div>
            <div className="col-xs-6 offset-md-2">
              <img
                src={pic}
                class="header__img"
                alt="svg image"
              />
            </div>
          </div>
        </div>

        <hr />

        <div className="section margin-section" id="section--1" >
          <div className="row">
            <div className="col-xs-12 offset-md-2">
              <div class="section__title">
                <h2 class="section__description">Features</h2>
                <h3 class="section__header">
                  Managing claims has never been so easy.
                </h3>
              </div>
            </div>
          </div>

        

          <div className="row justify-content-end">
            <div className="col-xs-6 col-md-6">
              <img
                src={pic1}
                data-src="../../assets/img/digital.jpg"
                alt="Computer"
                class="features__img lazy-img"
              />
            </div>

            

            <div className="col-xs-6 col-md-6 d-flex justify-content-center">
              <div class="features__feature">
                <div class="features__icon">
                  <svg>
                    <use xmlns={pic2}></use>
                  </svg>

                </div>
                <h5 class="features__header">Easy to use</h5>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde alias
                  sint quos? Accusantium a fugiat porro reiciendis saepe quibusdam
                  debitis ducimus.
                </p>
              </div>
            </div>
          </div>

          <div className="row justify-content-end margin-grid-row">
            <div className="col-xs-6 col-md-6 justify-content-center d-flex">
              <div class="features__feature">
                <div class="features__icon">
                  {/* <svg>
                  <use
                    xlink:href="../../assets/img/icons.svg#icon-credit-card"
                  ></use>
                </svg> */}
                </div>
                <h5 class="features__header">View all your claims</h5>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde alias
                  sint quos? Accusantium a fugiat porro reiciendis saepe quibusdam
                  debitis ducimus.
                </p>
              </div>
            </div>

            <div className="col-xs-6 col-md-6">
              <img
                src={pic4}
                // data-src="../../assets/img/digital.jpg"
                alt="Computer"
                class="features__img lazy-img"
              />
            </div>
          </div>

          <div className="row justify-content-end margin-grid-row">
            <div className="col-xs-6 col-md-6">
              <img
                src={pic3}
                alt="Computer"
                class="features__img lazy-img"
              />
            </div>

            <div className="col-xs-6 col-md-6 justify-content-center d-flex">
              <div class="features__feature">
                <div class="features__icon">
                  {/* <svg>
                  <use
                    xlink:href="../../assets/img/icons.svg#icon-trending-up"
                  ></use>
                </svg> */}
                </div>
                <h5 class="features__header">Track you claim status</h5>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde alias
                  sint quos? Accusantium a fugiat porro reiciendis saepe quibusdam
                  debitis ducimus.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>



    </div>
  );
}

export default Home;