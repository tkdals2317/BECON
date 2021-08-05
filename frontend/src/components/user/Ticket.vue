<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>티켓 예매</h2>
      </div>

      <div class="form-box">
        <div class="sec-title">
          <div class="ticket ticket-1">
            <div class="date">
              <span class="day">24</span>
              <span class="month-and-time"
                >{{ concertId.startTime }}<br /><span class="small">{{ concertId.endTime }}</span></span
              >
            </div>
            <div class="artist">
              <span class="name">STAND</span>
              <br />
              <span class="live small">{{ concertId.priceStand }}</span>
            </div>
            <div class="location">
              <span>{{ concertId.title }}</span>
              <br />
              <span class="live small"><span>{{ concertId.owner }}</span></span>
            </div>
            <div class="rip"></div>
            <div class="cta">
              <button class="buy" href="#">BUY TICKET</button>
            </div>
          </div>

          <div class="ticket ticket-2">
            <div class="date">
              <span class="day">24</span>
              <span class="month-and-time"
                >{{ concertId.startTime }}<br /><span class="small">{{ concertId.endTime }}</span></span
              >
            </div>
            <div class="artist">
              <span class="name"> VVVIP </span>
              <br />
              <span class="live small">{{ concertId.priceVip }}</span>
            </div>
            <div class="location">
              <span>{{ concertId.title }}</span>
              <br />
              <span class="small"><span>{{ concertId.owner }}</span></span>
            </div>
            <div class="rip"></div>
            <div class="cta">
              <button class="buy" href="#">BUY TICKET</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "Ticket",
  props: {
    concertId: Object,
  },
};
</script>

<style scoped>
body {
  background-color: #436ea5;
}

.ticket {
  font-family: sans-serif;
  background-repeat: no-repeat;
  background-position: top;
  background-size: 100%;
  background-color: #04030c;
  width: 700px;
  height: 300px;
  border-radius: 15px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  display: block;
  margin: 10% auto auto auto;
  color: #fff;
}

.date {
  margin: 15px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

.date .day {
  font-size: 80px;
  float: left;
}

.date .month-and-time {
  float: left;
  margin: 15px 0 0 0;
  font-weight: bold;
}

.artist {
  font-size: 40px;
  margin: 10px 100px 0 40px;
  float: left;
  font-weight: bold;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

.location {
  float: left;
  margin: 135px 0 0;
  font-size: 30px;
  font-weight: bold;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

/* .location::before {
  background-image: url('https://upload.wikimedia.org/wikipedia/commons/c/cb/QRCodeWikipedia.png');
  background-size: 50px 50px;
  margin: 0 0 0 0 ;
  width: 50px; 
  height: 50px;
  content:"";
  display: inline-block;
  float: left;
  position: absolute;
  left: -160px;
  bottom: 5px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
} */

.rip {
  border-right: 8px dotted #436ea5;
  height: 300px;
  position: absolute;
  top: 0;
  left: 530px;
}

.cta .buy {
  position: absolute;
  top: 135px;
  right: 15px;
  display: block;
  font-size: 12px;
  font-weight: bold;
  background-color: #436ea5;
  padding: 10px 20px;
  border-radius: 25px;
  color: #fff;
  text-decoration: none;
  -webkit-transform: rotate(-90deg);
  -ms-transform: rotate(-90deg);
  transform: rotate(-90deg);
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

.small {
  font-weight: 150;
}
.middle {
  font-weight: 300;
}

.ticket-1 {
  background-image: url(https://images.unsplash.com/photo-1483101974978-cf266fdf1139?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3289&q=80);
}

.ticket-2 {
  background-image: url(https://images.unsplash.com/photo-1550184658-ff6132a71714?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2180&q=80);
}
</style>
