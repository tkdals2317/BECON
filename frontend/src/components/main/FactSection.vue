<template>
  <section class="facts-section">
    <div
      class="image-layer"
    ></div>
    <div class="auto-container">
      <div class="inner-container">
        <!-- Fact Counter -->
        <div class="fact-counter" v-observe-visibility="onVisibilityChange">
          <div class="row clearfix">
            <!--Column-->
            <div class="column counter-column col-lg-3 col-md-6 col-sm-12">
              <div class="inner">
                <div class="content">
                  <div class="count-outer count-box">
                    <span class="count-text"
                      ><countTo
                        :startVal="0"
                        :endVal="startCounter ? getTotalUser : 0"
                        :duration="3000"
                      ></countTo
                    ></span>
                  </div>
                  <div class="counter-title">Fans With Us</div>
                </div>
              </div>
            </div>

            <!--Column-->
            <div class="column counter-column col-lg-3 col-md-6 col-sm-12">
              <div class="inner">
                <div class="content">
                  <div class="count-outer count-box alternate">
                    <span class="count-text"
                      ><countTo
                        :startVal="0"
                        :endVal="startCounter ? getTotalTicket : 0"
                        :duration="3000"
                      ></countTo
                    ></span>
                  </div>
                  <div class="counter-title">total reservations</div>
                </div>
              </div>
            </div>

            <!--Column-->
            <div class="column counter-column col-lg-3 col-md-6 col-sm-12">
              <div class="inner">
                <div class="content">
                  <div class="count-outer count-box">
                    <span class="count-text"
                      ><countTo
                        :startVal="0"
                        :endVal="startCounter ? getTotalConcert : 0"
                        :duration="3000"
                      ></countTo
                    ></span>
                  </div>
                  <div class="counter-title">total Concerts</div>
                </div>
              </div>
            </div>

            <!--Column-->
            <div class="column counter-column col-lg-3 col-md-6 col-sm-12">
              <div class="inner">
                <div class="content">
                  <div class="count-outer count-box">
                    <span class="count-text"
                      ><countTo
                        :startVal="0"
                        :endVal="startCounter ? getIngConcert : 0"
                        :duration="3000"
                      ></countTo
                    ></span>
                  </div>
                  <div class="counter-title">Ongoing concert</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import countTo from "vue-count-to";
import { ObserveVisibility } from "vue-observe-visibility";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "FactSection",
  components: { countTo },
  directives: {
    ObserveVisibility,
  },
  data() {
    return {
      startCounter: false,
    };
  },
  created() {
    this.findTotalConcert();
    this.findTotalUser();
    this.findTotalTicket();
    this.findIngConcert();
  },
  computed: {
    ...mapGetters("concert", ["getTotalConcert", "getIngConcert"]),
    ...mapGetters("user", ["getTotalUser"]),
    ...mapGetters("ticket", ["getTotalTicket"]),
  },
  methods: {
    ...mapActions("concert", ["findTotalConcert", "findIngConcert"]),
    ...mapActions("user", ["findTotalUser"]),
    ...mapActions("ticket", ["findTotalTicket"]),
    onVisibilityChange(isVisible) {
      if (isVisible) {
        this.startCounter = true;
      }
    },
  },
};
</script>
